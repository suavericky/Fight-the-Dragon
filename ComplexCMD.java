
public class ComplexCMD {
	
	private String command,option;
	
	public ComplexCMD(){
		//Default Constructor
	}
	
	public ComplexCMD(String c, String o){
		this.command = c;
		this.option = o;
	}
	
	public String getCommand(){
		return this.command;
	}
	
	public String getOption(){
		return this.option;
	}
	
	public void setCommand(String c){
		this.command = c;
	}
	
	public void setOption(String o){
		this.option = o;
	}

}
