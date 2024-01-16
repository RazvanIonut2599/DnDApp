package com.Base.dndcharactersheet.HolderClasses;

public class CharacterHolder {

    public String filename;
    public String characterName;
    public CharacterHolder(){
        this.filename="";
        this.characterName="";
    }
    public CharacterHolder(String filename,String characterName){
        this.filename=filename;
        this.characterName=characterName;
    }
}
