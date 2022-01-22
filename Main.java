import java.io.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
        byte[] buf16 = new byte[16]; //16바이트 버퍼
        int buf16Len;
        int offset = 0; //번지
        DataInputStream in = new DataInputStream(new FileInputStream("FAT32_simple.mdf"));
        
        while ((buf16Len = in.read(buf16)) > 0) {
            // 헥사 구역의 헥사 값 16개 출력 (8개씩 2부분으로)
            for (int i = 0; i < buf16Len; i++) {
              if (i == 8) System.out.print(" ");    // 8개씩 분리
              System.out.format("%02X ", buf16[i]); // 헥사 값 출력
            }
            offset += 16; // 번지 값을 16 증가
            System.out.println(); // 줄바꿈
            if(offset > 160) break;
        }
          in.close();
        }
}