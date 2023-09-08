// C++ program to illustrate the
// iterators in vector
#include <cstring>
#include <string>
#include <iostream>
#include <vector>
#include <fstream>
#include <dirent.h>
#include <boost/lexical_cast.hpp>
#include  <stdio.h>
#include  <sys/types.h>
 
using namespace std;
//Function representing ps -A
vector<string> list_processes()
{
    vector<string> list;
    
    DIR *dir = opendir("/proc");

    struct dirent *entry = readdir(dir);
    while((entry = readdir(dir))){
        string holder = entry->d_name;
        int i;
        try{
            i = boost::lexical_cast<int>( holder.c_str());
        }
        catch(exception){
            i = 0;
        }
        if((int) i != NULL || (int) i != 0){
            string firstPath = "/proc/";
            string secondPath = entry->d_name;
            string pathString = firstPath + secondPath + "/comm";
            const char* path = pathString.c_str();
            string processName = "";
            ifstream file;
            file.open(path);
            if (file.good())
            {
                getline(file, processName);
                list.push_back(processName);
            }
        }
    }

    return list;
}
//Function representing grep
int countProcess(vector<string> processes, string arg){
    int count = 0;
    for(int i = 0; i < processes.size(); i++){
        if(processes.at(i).substr(0,arg.length()) == arg){
            count ++;
        }
    }
    return count;
}

int main(int argc, char** argv)
{
    pid_t child, grandchild, greatgrandchild;
    string arg = argv[1]; //Take given argument turn it into string
    int count = 0;
    child = fork(); //Create first process
    vector<string> processes;
    if(child == 0){
        grandchild = fork();
        if(grandchild == 0){
            greatgrandchild = fork();
            if(greatgrandchild == 0){
                processes = list_processes(); //Execute greatgrandchild first
            }
            count = countProcess(processes,arg); //Execute grandchild second
        }
        
        cout << count; //Execute child last
    }
}