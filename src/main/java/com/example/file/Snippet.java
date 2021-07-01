package com.example.file;

import java.io.*;
import java.util.Base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Snippet {
    /**
     * Description: 将pdf文件转换为Base64编码
     *
     * @param
     * @Author fuyuwei Create Date: 2015年8月3日 下午9:52:30
     */
    public static String PDFToBase64(File file) {
        FileInputStream fin = null;
        BufferedInputStream bin = null;
        ByteArrayOutputStream baos = null;
        BufferedOutputStream bout = null;
        try {
            fin = new FileInputStream(file);
            bin = new BufferedInputStream(fin);
            baos = new ByteArrayOutputStream();
            bout = new BufferedOutputStream(baos);
            byte[] buffer = new byte[1024];
            int len = bin.read(buffer);
            while (len != -1) {
                bout.write(buffer, 0, len);
                len = bin.read(buffer);
            }
            // 刷新此输出流并强制写出所有缓冲的输出字节
            bout.flush();
            byte[] bytes = baos.toByteArray();
            return Base64.getEncoder().encodeToString(bytes).trim();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fin.close();
                bin.close();
                bout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * Description: 将base64编码内容转换为Pdf
     *
     * @param
     * @Author fuyuwei Create Date: 2015年7月30日 上午9:40:23
     */
    public static void base64StringToPdf(String base64Content, String filePath) {
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;

        try {

            byte[] decode = Base64.getDecoder().decode(base64Content);
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(
                    decode);
            bis = new BufferedInputStream(byteInputStream);
            File file = new File(filePath);
            File path = file.getParentFile();
            if (!path.exists()) {
                path.mkdirs();
            }
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[1024];
            int length = bis.read(buffer);
            while (length != -1) {
                bos.write(buffer, 0, length);
                length = bis.read(buffer);
            }
            bos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // closeStream(bis, fos, bos);
        }
    }

    public static String PDFToBase64Byte(File file) {
        FileInputStream fin = null;
        ByteArrayOutputStream baos = null;
        BufferedOutputStream bout = null;
        try {
            fin = new FileInputStream(file);
            baos = new ByteArrayOutputStream();
            bout = new BufferedOutputStream(baos);
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fin.read(buffer)) != -1) {
                bout.write(buffer, 0, len);
            }
            // 刷新此输出流并强制写出所有缓冲的输出字节
            bout.flush();
            byte[] bytes = baos.toByteArray();
            return Base64.getEncoder().encodeToString(bytes).trim();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fin.close();
                bout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void base64StringToPdfByByte(String base64Content, String filePath) {
        FileOutputStream fos = null;
        ObjectOutputStream bos = null;
        ByteArrayOutputStream baos = null;
        try {
            byte[] decode = Base64.getDecoder().decode(base64Content);
            baos = new ByteArrayOutputStream(decode.length);
            File file = new File(filePath);
            File path = file.getParentFile();
            if (!path.exists()) {
                path.mkdirs();
            }
            baos.write(decode);
            baos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // closeStream(bis, fos, bos);
        }
    }

    public static void main(String[] args) throws IOException {
        String path = "d:\\123.pdf";
        String filePath = "E:\\temp\\1608864073923.pdf";
//        File file = new File(filePath);
////        String s = PDFToBase64(file);
////        base64StringToPdf(s, path);
//        String s = PDFToBase64Byte(file);
//        base64StringToPdfByByte(s, path);


        String str = "JVBERi0xLjQKJeLjz9MKMyAwIG9iago8PC9MZW5ndGggNzY2L0ZpbHRlci9GbGF0ZURlY29kZT4+c3RyZWFtCnicrZZNaBNBFMcHaXvYg+BFoZdMT7aWrDsz+9lexE8U3bDdLZK62lhdAxqrjV2lKDWCihBPxVoP3vRooRcF6bkHi1KkF68qBS9eRDzoIb7ZZLVpzWxik2VnEt78f/PfeW9mMyHt9yRNwYZFsXdeIooqazjNLP5j72GCqY69CxLEipIim7quG/iG1Guv+f68PVPybjvu4OOx2S/l5XDJvd/nXZQUPpTAoHSVpXCSgtPErCIpJpQje3F1dBynajwlWT+lxuDDp8w9K3VmPuau1M2hNI032+XD90l5WWREkw3tDwKE0SSRKvgx+73SjTwUogBhdBDac9BTZEFLkIIGkIZ0aAn0GB1ALozlcSW6Mb+m3p96Xul27g11Fd7WG9/qg9mD5TctPRPPyF9Ru2xcW4BK+taSkfWSdtkIPo2WWrTBJe03Yvvjl3rKy4VFb/v1u+FSbsn94O70HhYWwzn33ZlHLTmM5e11CIU9P72af9qSlXpRu6xkOya7Kv4YnEZz5YXRYdSf7QheV/zJlqzB9pPPppyZ8c6rX5/M3ZqJNidFeYTdz3m/iLCNsn6f7U9e6kF7kAHflW0bHiPm9oJO/o9VZ1ZDd+5gmLo57flFOElGN18ckubyiHPIkxxpIropPgb0I3y1YA2YAZ1uMGzqMhzpVMHFQHJrQUJVmRgNwxS8mKxx2BKxmSlkq4aQXbWtiW03CMe2G4UtETu23SAc226kjtBMbBvCKmMydP8SE7GYbBI7/MVOMC8EgnUqW3xVoYQui7bPKtQVGqjbLVBC60BEZVFyE0AP7hTMqUDAoUyX4a9FIii3e6hfaIgxWi2YBFBoiCAWk5sw4/wMU8FaPiU0pEKlNMGCI8WCtzyJ3vsKsgTEWvK0BGJhR7Aizp1GogpP4hwNVkSZo0qUuSTMyEj2V/GV81KcPbW2bxJgovVWLLkJO6XjdrfQikZqO3wLVvQoUSyBcHot4/vucOZEU0uTREsuHJJAyGRO7hNbgUPGbALk7rJfbMT8Biy3wzkKZW5kc3RyZWFtCmVuZG9iago1IDAgb2JqCjw8L1R5cGUvUGFnZS9NZWRpYUJveFswIDAgNTk1IDg0Ml0vUmVzb3VyY2VzPDwvRm9udDw8L0YxIDEgMCBSL0YyIDIgMCBSPj4+Pi9Db250ZW50cyAzIDAgUi9QYXJlbnQgNCAwIFI+PgplbmRvYmoKNiAwIG9iago8PC9UeXBlL0ZvbnREZXNjcmlwdG9yL0FzY2VudCA4ODAvQ2FwSGVpZ2h0IDg4MC9EZXNjZW50IC0xMjAvRmxhZ3MgNi9Gb250QkJveCBbLTI1IC0yNTQgMTAwMCA4ODBdL0ZvbnROYW1lL1NUU29uZy1MaWdodC9JdGFsaWNBbmdsZSAwL1N0ZW1WIDkzL1N0eWxlPDwvUGFub3NlKAEFAgIEAAAAAAAAACk+Pj4+CmVuZG9iago3IDAgb2JqCjw8L1R5cGUvRm9udC9TdWJ0eXBlL0NJREZvbnRUeXBlMC9CYXNlRm9udC9TVFNvbmctTGlnaHQvRm9udERlc2NyaXB0b3IgNiAwIFIvVyBbMVsyMDddMTFbNDIzIDYwNV0xNVsyMzhdMTcgMTkgNDYyIDIyIDI0IDQ2MiAyNls0NjIgMjM4XTM2WzY5NSA3MzldNTJbNDY1IDYwN102NFs1MDBdNjhbNDI3XTcwWzQxNV03Mls0NDRdODZbNTE3XV0vRFcgMTAwMC9DSURTeXN0ZW1JbmZvPDwvUmVnaXN0cnkoQWRvYmUpL09yZGVyaW5nKEdCMSkvU3VwcGxlbWVudCA0Pj4+PgplbmRvYmoKMSAwIG9iago8PC9UeXBlL0ZvbnQvU3VidHlwZS9UeXBlMC9CYXNlRm9udC9TVFNvbmctTGlnaHQtVW5pR0ItVUNTMi1IL0VuY29kaW5nL1VuaUdCLVVDUzItSC9EZXNj";
        str = PDFToBase64(new File(filePath));
        System.out.println(str);
        File file = new File(path);
        File apath = file.getParentFile();
        if (!apath.exists()) {
            apath.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(Base64.getDecoder().decode(str));
//        base64StringToPdfByByte(s, path);
        System.out.println("over");
    }
}
