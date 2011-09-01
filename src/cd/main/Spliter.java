package cd.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.text.NumberFormat;
import java.util.ArrayList;


/**
 * 公司用的分包类,抽时间看看.
 * @author Administrator
 *
 */
public class Spliter
{
  boolean deleteSourceFile;
  boolean overrideExistFile;
  public static int FILE_READ_BUFFER_SIZE = 16384;
  public static long MAX_FILE_SIZE = 20971520L;

  public File[] split(File srcFile)
  {
    return split(srcFile, MAX_FILE_SIZE);
  }

  public File[] split(String srcFile)
  {
    File file = new File(srcFile);
    return split(file);
  }

  public File[] split(File srcFile, long maxFileSize)
  {
    ArrayList<File> result = new ArrayList<File>();
    FileInputStream in = null;
    FileOutputStream out = null;
    MessageDigest md = null;
    FileOutputStream validCodeOut = null;
    try
    {
      md = MessageDigest.getInstance("md5");
      in = new FileInputStream(srcFile);

      String fileName = srcFile.getAbsolutePath() + "." + result.size();
      File file = new File(fileName);
      result.add(file);
      out = new FileOutputStream(file);

      int bufferSize = maxFileSize > FILE_READ_BUFFER_SIZE ? FILE_READ_BUFFER_SIZE : (int)maxFileSize;

      byte[] buffer = new byte[bufferSize];
      long totalCount = 0L;
      int index = 0;
      int count = in.read(buffer);
      while (count != -1)
      {
        totalCount += count;
        if (totalCount > maxFileSize)
        {
          index++;
          out.close();

          String validCode = toHexString(md.digest());
          String validCodeFile = fileName + ".MD5";
          validCodeOut = new FileOutputStream(validCodeFile);
          validCodeOut.write(validCode.getBytes());
          validCodeOut.close();
          validCodeOut = null;

          fileName = srcFile.getAbsolutePath() + "." + result.size();
          file = new File(fileName);
          if (file.exists())
          {
            if (this.overrideExistFile)
            {
              boolean b = file.delete();
              if (b) {
                System.out.println("Over write exists file: " + file.getAbsolutePath());
              }
              else
                System.out.println("Over write exists file failed: " + file.getAbsolutePath());
            }
            else
            {
                System.out.println("File aread exists, you may move it to another place first: " + file.getAbsolutePath());
                return null;
            }
          }

          result.add(file);
          out = new FileOutputStream(file);

        }
        out.write(buffer, 0, count);
        md.update(buffer, 0, count);
        count = in.read(buffer);
      }

      String validCode = toHexString(md.digest());
      String validCodeFile = fileName + ".MD5";
      validCodeOut = new FileOutputStream(validCodeFile);
      validCodeOut.write(validCode.getBytes());
      validCodeOut.close();
      validCodeOut = null;

      in.close();
      in = null;
      out.close();
      out = null;
    }
    catch (Exception e) {
      while (true) {
        e.printStackTrace();
      }
    }
    finally
    {
      if (in != null)
        try
        {
          in.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
      if (out != null)
        try
        {
          out.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
      if (validCodeOut != null)
        try
        {
          validCodeOut.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
    }

    if (this.deleteSourceFile)
    {
      if (srcFile.delete())
        System.out.println("Source file deleted: " + srcFile.getAbsolutePath());
      else {
        System.out.println("Source file deleting fail: " + srcFile.getAbsolutePath());
      }
    }

    File[] _result = new File[result.size()];
    for (int i = 0; i < _result.length; i++)
      _result[i] = ((File)result.get(i));
    return _result;
  }

  public boolean isDeleteSourceFile()
  {
    return this.deleteSourceFile;
  }

  public void setDeleteSourceFile(boolean deleteSourceFile)
  {
    this.deleteSourceFile = deleteSourceFile;
  }

  public boolean isOverrideExistFile()
  {
    return this.overrideExistFile;
  }

  public void setOverrideExistFile(boolean overrideExistFile)
  {
    this.overrideExistFile = overrideExistFile;
  }

  public static String toHexString(byte[] data)
  {
    char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    char[] temp = new char[data.length * 2];
    for (int i = 0; i < data.length; i++)
    {
      byte b = data[i];
      temp[(i * 2)] = hexDigits[(b >>> 4 & 0xF)];
      temp[(i * 2 + 1)] = hexDigits[(b & 0xF)];
    }
    return new String(temp);
  }

  private static File[] rename(File[] splitedFile, String[] newName) {
    File[] newFile = new File[splitedFile.length];
    for (int j = 0; j < splitedFile.length; j++)
    {
      File file = new File(splitedFile[j].getParent() + System.getProperty("file.separator") + newName[j]);
      newFile[j] = file;

      if (file.exists())
      {
        file.delete();
        System.out.println("覆盖已存在文件：" + file.getAbsolutePath());
      }
      boolean renamed = splitedFile[j].renameTo(file);
      if (!renamed)
      {
        System.out.println("改名失败" + splitedFile[j].getAbsolutePath() + " --> " + file.getAbsolutePath());
        return null;
      }

      File validFile = new File(splitedFile[j].getAbsolutePath() + ".MD5");
      File newValidFile = new File(file.getAbsolutePath() + ".MD5");
      if (newValidFile.exists())
        newValidFile.delete();
      validFile.renameTo(newValidFile);
    }
    return newFile;
  }

  private static String[] getSplitedFileName(String orangeFileName, File[] splitedFile)
  {
    NumberFormat sequenceNumberFormat = NumberFormat.getInstance();
    sequenceNumberFormat.setMaximumFractionDigits(0);
    sequenceNumberFormat.setMinimumIntegerDigits(3);
    String fileCount = sequenceNumberFormat.format(splitedFile.length);

    String[] newName = new String[splitedFile.length];
    for (int j = 0; j < splitedFile.length; j++)
    {
      String fileSequence = sequenceNumberFormat.format(j + 1);
      StringBuffer name = new StringBuffer(orangeFileName);

      int positionOfDot = name.lastIndexOf(".");
      if (positionOfDot <= 17)
      {
        name.setCharAt(positionOfDot - 4, '1');
      }
      else {
        name.replace(positionOfDot - 6, positionOfDot - 3, fileCount);
        name.replace(positionOfDot - 3, positionOfDot, fileSequence);
        name.setCharAt(positionOfDot - 7, '1');
      }
      newName[j] = name.toString();
    }
    return newName;
  }

  public static void main(String[] args)
  {
    if (args.length < 1)
    {
      System.out.println("缺少分包参数,参考命令执行: java Spliter bz2fileName");
      return;
    }

    Spliter spliter = new Spliter();
    spliter.setDeleteSourceFile(false);
    spliter.setOverrideExistFile(true);
    File[] splitedFile = spliter.split(args[0]);
    if (splitedFile == null)
    {
      System.out.println("文件:" + args[1] + " 分包失败");
    }

    String[] newName = getSplitedFileName(args[0], splitedFile);

    File[] newFile = rename(splitedFile, newName);
  }
}
