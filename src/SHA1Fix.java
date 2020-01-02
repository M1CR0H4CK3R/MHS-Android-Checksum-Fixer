import java.util.Arrays;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.io.IOUtils;

public class SHA1Fix
{
	public static void main(String[] args) throws Exception
	{
        try
        {
        	File file = new File(System.getProperty("user.home")+"\\Desktop\\MHS-Android-Checksum-Fixer\\mhr_game0.sav");
    		// Separate the header and data into different arrays, ignoring the currently stored checksum
    		InputStream bytes = new FileInputStream(file);
    		byte[] fileArray = IOUtils.toByteArray(bytes);
    		if (fileArray.length == 789392)
    		{
    			try
    			{
    			InputStream input = new ByteArrayInputStream(fileArray);
    			byte[] header1 = IOUtils.toByteArray(input, 12);
    			input.skip(20);
    			byte[] header2 = IOUtils.toByteArray(input, 32);
    			byte[] fileData = IOUtils.toByteArray(input, 789328);
    			// Calculate the SHA-1 of the data and split it into 5 parts.
    			MessageDigest digest = MessageDigest.getInstance( "SHA-1" ); 
    			digest.update(fileData, 0, fileData.length);
    			byte[] checksum = digest.digest();
    			byte[] checksumA = Arrays.copyOfRange(checksum,0,4);
    			byte[] checksumB = Arrays.copyOfRange(checksum,4,8);
    			byte[] checksumC = Arrays.copyOfRange(checksum,8,12);
    			byte[] checksumD = Arrays.copyOfRange(checksum,12,16);
    			byte[] checksumE = Arrays.copyOfRange(checksum,16,20);
    			// Convert checksum parts to Little Endian ByteBuffer.
    			int chksumA = ByteBuffer.wrap(checksumA).getInt();
    			byte[] cksumA = new byte[4];
    			cksumA[0] = (byte) (chksumA & 0xFF);
    			cksumA[1] = (byte) ((chksumA >> 8) & 0xFF);
    			cksumA[2] = (byte) ((chksumA >> 16) & 0xFF);
    			cksumA[3] = (byte) ((chksumA >> 24) & 0xFF);
    			int chksumB = ByteBuffer.wrap(checksumB).getInt();
    			byte[] cksumB = new byte[4];
    			cksumB[0] = (byte) (chksumB & 0xFF);
    			cksumB[1] = (byte) ((chksumB >> 8) & 0xFF);
    			cksumB[2] = (byte) ((chksumB >> 16) & 0xFF);
    			cksumB[3] = (byte) ((chksumB >> 24) & 0xFF);
    			int chksumC = ByteBuffer.wrap(checksumC).getInt();
    			byte[] cksumC = new byte[4];
    			cksumC[0] = (byte) (chksumC & 0xFF);
    			cksumC[1] = (byte) ((chksumC >> 8) & 0xFF);
    			cksumC[2] = (byte) ((chksumC >> 16) & 0xFF);
    			cksumC[3] = (byte) ((chksumC >> 24) & 0xFF);
    			int chksumD = ByteBuffer.wrap(checksumD).getInt();
    			byte[] cksumD = new byte[4];
    			cksumD[0] = (byte) (chksumD & 0xFF);
    			cksumD[1] = (byte) ((chksumD >> 8) & 0xFF);
    			cksumD[2] = (byte) ((chksumD >> 16) & 0xFF);
    			cksumD[3] = (byte) ((chksumD >> 24) & 0xFF);
    			int chksumE = ByteBuffer.wrap(checksumE).getInt();
    			byte[] cksumE = new byte[4];
    			cksumE[0] = (byte) (chksumE & 0xFF);
    			cksumE[1] = (byte) ((chksumE >> 8) & 0xFF);
    			cksumE[2] = (byte) ((chksumE >> 16) & 0xFF);
    			cksumE[3] = (byte) ((chksumE >> 24) & 0xFF);
    			ByteBuffer checksumFinal = ByteBuffer.allocate(20).put(cksumA).put(cksumB).put(cksumC).put(cksumD).put(cksumE);
    			checksumFinal.position(0);
    			// Convert all other data to ByteBuffer.
    			ByteBuffer header1Buf = ByteBuffer.wrap(header1);
    			ByteBuffer header2Buf = ByteBuffer.wrap(header2);
    			ByteBuffer fileDataBuf = ByteBuffer.wrap(fileData);
    			// Combine all the data together and write the data to files.
    			ByteBuffer fileFinal = ByteBuffer.allocate(789392).put(header1Buf).put(checksumFinal).put(header2Buf).put(fileDataBuf);
    			fileFinal.position(0);
				try (FileOutputStream fos1 = new FileOutputStream(System.getProperty("user.home")+"\\Desktop\\MHS-Android-Checksum-Fixer\\output\\mhr_game0.sav");
					FileChannel output1 = fos1.getChannel())
				{
    			output1.write(fileFinal);
    			output1.close();
				}
				catch (IOException i)
				{
				}
				fileFinal.position(0);
				try (FileOutputStream fos2 = new FileOutputStream(System.getProperty("user.home")+"\\Desktop\\MHS-Android-Checksum-Fixer\\output\\mhr_game0_bk.sav");
					FileChannel output2 = fos2.getChannel())
				{
    			output2.write(fileFinal);
				output2.close();
				}
			catch (IOException j)
				{
				}
				fileFinal.position(0);
				try (FileOutputStream fos3 = new FileOutputStream(System.getProperty("user.home")+"\\Desktop\\MHS-Android-Checksum-Fixer\\output\\mhr_game1.sav");
						FileChannel output3 = fos3.getChannel())
					{
	    			output3.write(fileFinal);
					output3.close();
					}
				catch (IOException k)
					{
					}
				fileFinal.position(0);
				try (FileOutputStream fos4 = new FileOutputStream(System.getProperty("user.home")+"\\Desktop\\MHS-Android-Checksum-Fixer\\output\\mhr_game1_bk.sav");
						FileChannel output4 = fos4.getChannel())
					{
	    			output4.write(fileFinal);
					output4.close();
					}
				catch (IOException l)
					{
					}
    			}
    			catch (IOException n)
    			{
    			}
    			return;
    		}
    		else
    		{
    			System.out.println("Input file is incorrect size! Aborting...");
    			return;
    		}
        }
        catch (FileNotFoundException e)
        {
        e.printStackTrace();
        }
        catch (IOException e)
        {
        e.printStackTrace();
        }
        catch (NoSuchAlgorithmException e)
        {
        e.printStackTrace();
        }
    }
}