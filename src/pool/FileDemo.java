package pool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileDemo { 
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		final String PATH = "C:\\Users\\1027\\Documents\\sample.txt"; //upload.
		try {
			File file = new File(PATH);
			FileWriter fw;
			fw = new FileWriter(file, true);
			FileReader fr = new FileReader(file);
			BufferedWriter writer = new BufferedWriter(fw);
			BufferedReader reader = new BufferedReader(fr);
			while(true) {
				System.out.println("[메뉴] 1.전송 2.읽기 0.종료");
				switch (s.next()) {
				case "1":
					System.out.println("메시지 입력");
					writer.write(s.next());
					writer.newLine(); //안녕하고 엔터치면 줄바꿈. 방가 엔터치면 먹힘
					writer.flush(); // 
					break;
				case "2":
					System.out.println("메시지 입력");
					String msg = reader.readLine();
					while((msg=reader.readLine())
							!=null) {
						System.out.println(msg);
					}
					reader.close();
					break;
				case "0":
					break;

				default:
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //boolean이 true면 이어쓰기한다는거
		
		FileName fn = new FileName(PATH);
		System.out.println(" " + fn.getFilename());
		System.out.println(" " + fn.getExt());
	}
}




class FileName{ //이너클라스 이너는 롬복 잘 안먹음.
	 //Inner class = public 을 갖지 않는다
	 // 이유는 이 클래스 내부에서만 사용하고자 함이다.
	// 만약 다른곳에서 계속 사용한다면 독립시켜야한다. 
	// 1회용 사용 클래스라고 생각.
	private String path, sep, ext, filename;
	public FileName(String path) {
		this.path = path;
		this.sep = File.separator;  
		this.ext = path.substring(path.lastIndexOf(".")+1,path.length());
		this.filename = path.substring(path.lastIndexOf("\\")+1,path.lastIndexOf("."));
	}
		public String getPath() {
			return path;
		}
		public String getSep() {
			
			return sep;
		}
		public String getExt() {
			return ext;
		}
		public String getFilename() {
			return filename;
		}
		
	/*private String FullPath;
	String pathSeparator;
	String extensionSeparator; //.
	public FileName(String path,
			String sep, String ext) {   //생성자를 디폴트안씀..? //원래 sep, ext는 char임
			FullPath = path;
			pathSeparator = sep;
			extensionSeparator = ext;
	}

	public String fileName(String fullPath) {
		this.FullPath = fullPath;
		return "";
	}
	public String pathSeparator(String pathSeparator) {
		this.pathSeparator = pathSeparator;
		System.out.println(
				"윈도우 파일구분자: "+File.separator);
		//"/" -> 윈도우임 
		return File.separator;
	}
	// 확장자 exe, java, 이런거.... 확장자를 뽑아내는거임 
	public String extension(String extensionSeparator) {
		this.extensionSeparator = extensionSeparator;
		int dot = FullPath.lastIndexOf(extensionSeparator);
		System.out.println("dot의 위치 " + dot);
		return "";
	}*/
	
}

