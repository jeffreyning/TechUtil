package com.github.jeffreyning.techutil;

/**
 * @author ninghao
 */
public class CMD {
    private String cmdName;
    private CMD(){};
    public static CMD BREAK(){
        CMD ac=new CMD();
        ac.cmdName="break";
        return ac;
    }
    public static CMD CONTINUE(){
        CMD ac=new CMD();
        ac.cmdName="continue";
        return ac;
    }
    public boolean isBreak(){
        if("break".equals(cmdName)){
            return true;
        }
        return false;
    }
}
