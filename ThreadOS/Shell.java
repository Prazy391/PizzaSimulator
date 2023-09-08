
class Shell extends Thread
{
    private String name = "none";
    public Shell()
    {
        SysLib.cout("Starting");
    }

    public boolean checkExit(String commands[])
    {
        return commands[0].compareTo("exit") == 0;
    }
    public void run()
    {
        boolean exit = false;
        int count = 1;
        while(!exit)
        {
            SysLib.cout("Shell["+ count +"]: ");
            StringBuffer userCommand = new StringBuffer();
            SysLib.cin(userCommand);
            String[] commands = SysLib.stringToArgs(userCommand.toString());
            if(commands.length < 1)
            {
                continue;
            }
            exit = checkExit(commands);
            if(exit)  
                 break;
            SysLib.cout("\n");
            count += 1;
            String command = userCommand.toString();
            execute(command);
        }
        SysLib.cout("Exitting");
        SysLib.sync();
        SysLib.exit();
    }

    public void execConc(String [] args)
    {
        int processCount = 0;
        for (int i = 0; i < args.length; i++){
            String[] commands = SysLib.stringToArgs(args[i]);
            
            SysLib.cout(commands[0] + "\n\t");
            if (SysLib.exec(commands) < 0)
                processCount--;
            processCount++;
        }

        for (int j = 0; j < processCount; j++) 
            SysLib.join();
    }

    public void execute(String args)
    {
        String[] seqTasks = args.toString().split(";");

        for (int i = 0; i < seqTasks.length; i++)
        {
            SysLib.cout(seqTasks[i]+"\n");
            String[] concTasks = seqTasks[i].split("&");
            if (concTasks.length == 1)
                execCMD(seqTasks[i]);
            else
                execConc(concTasks);
        }  
    }

    public void execCMD(String argument)
    {
        String [] args = SysLib.stringToArgs(argument);
        if (SysLib.exec(args) > 0)
            SysLib.join();
    }
}