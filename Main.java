import java.io.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
    byte[] buf16 = new byte[16]; //16바이트 버퍼
    int buf16Len;
    int offset = 0; //번지
    DataInputStream in = new DataInputStream(new FileInputStream("FAT32_simple.mdf"));

    String S_Bytes_Per_Sector = "";
    String S_Sector_Per_Cluster = "";
    String S_Reserved_Sector_Count = "";
    String S_Num_Of_FAT = "";
    String S_FAT_Size_32 = "";
    String S_Root_Directory_Cluster = "";
      
    in.read(buf16);
    S_Bytes_Per_Sector += String.format("%02x%02x", buf16[11], buf16[12]);
    S_Sector_Per_Cluster += String.format("%02x", buf16[13]);
    S_Reserved_Sector_Count += String.format("%02x%02x", buf16[14], buf16[15]);
    in.read(buf16);
    S_Num_Of_FAT += String.format("%02x", buf16[15]);
    in.read(buf16);
    S_FAT_Size_32 += String.format("%02x%02x%02x%02x", buf16[4],buf16[5],buf16[6],buf16[7]);
    S_Root_Directory_Cluster += String.format("%02x%02x%02x%02x", buf16[12],buf16[13],buf16[14],buf16[15]);

    long Bytes_Per_Sector = Long.parseLong(S_Bytes_Per_Sector,16);
    long Sector_Per_Cluster = Long.parseLong(S_Sector_Per_Cluster,16);
    long Reserved_Sector_Count = Long.parseLong(S_Reserved_Sector_Count,16);
    long Num_Of_FAT = Long.parseLong(S_Num_Of_FAT,16);
    long FAT_Size_32 = Long.parseLong(S_FAT_Size_32,16);
    long Root_Directory_Cluster = Long.parseLong(S_Root_Directory_Cluster,16);

    System.out.print(FAT_Size_32);
    in.close();
  }
}