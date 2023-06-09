import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main5 {
	public static void main(String[] args) {
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream(new File("d:\\filetest\\primary.bin")));

			dos.writeUTF("문자열");
			dos.writeInt(100);
			dos.writeDouble(55.55);
			dos.writeBoolean(true);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
