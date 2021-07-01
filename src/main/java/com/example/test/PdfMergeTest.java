package com.example.test;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.Test;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Bruce Lee
 * @Date: 2021/1/14
 * @Description:
 */
public class PdfMergeTest {

    @Test
    public void mergePdf() throws IOException {
        File file1 = new File("E:\\temp\\wechat\\WeChat Files\\wxid_572olvzu56xy22\\FileStorage\\File\\2021-01\\使用PDF创建合同 (1)(1).pdf");
        PDDocument doc1 = PDDocument.load(file1);
        File file2 = new File("E:\\temp\\wechat\\WeChat Files\\wxid_572olvzu56xy22\\FileStorage\\File\\2021-01\\使用PDF创建合同 (2)(1).pdf");
        PDDocument doc2 = PDDocument.load(file2);
        File file3 = new File("E:\\temp\\wechat\\WeChat Files\\wxid_572olvzu56xy22\\FileStorage\\File\\2021-01\\使用PDF创建合同 (3).pdf");
        PDDocument doc3 = PDDocument.load(file3);


        PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();
        pdfMergerUtility.setDestinationFileName("E:\\桌面\\merged23.pdf");

        pdfMergerUtility.addSource(file1);
        pdfMergerUtility.addSource(file2);
//        pdfMergerUtility.addSource(file3);

        pdfMergerUtility.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());

        System.out.println("Documents merged");
        //Closing the documents
        doc1.close();
        doc2.close();
        doc3.close();
    }

    @Test
    public void mergePdfByte() throws IOException {
        File file1 = new File("E:\\temp\\wechat\\WeChat Files\\wxid_572olvzu56xy22\\FileStorage\\File\\2021-01\\使用PDF创建合同 (1).pdf");
        File file2 = new File("E:\\temp\\wechat\\WeChat Files\\wxid_572olvzu56xy22\\FileStorage\\File\\2021-01\\使用PDF创建合同 (2).pdf");
//        File file3 = new File("E:\\temp\\wechat\\WeChat Files\\wxid_572olvzu56xy22\\FileStorage\\File\\2021-01\\使用PDF创建合同 (3).pdf");
        FileInputStream fis1 = new FileInputStream(file1);
        FileInputStream fis2 = new FileInputStream(file2);
//        FileInputStream fis3 = new FileInputStream(file3);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        StringBuffer sb = new StringBuffer();
        byte[] buffer = new byte[1024];
        byte[] data = new byte[1024 * 1024 * 10];
        int len = 0;
        while ((len = fis1.read(buffer)) != -1) {
//            sb.append(new String(buffer, 0, len));
            baos.write(buffer, 0, len);
        }
//        baos.flush();
        int p1 = baos.toByteArray().length;
        System.arraycopy(baos.toByteArray(), 0, data, 0, p1);
        while ((len = fis2.read(buffer)) != -1) {
//            sb.append(new String(buffer, 0, len));
            baos.write(buffer, 0, len);
        }
//        baos.flush();
        int p2 = baos.toByteArray().length;
        System.arraycopy(baos.toByteArray(), 0, data, p1 + 1, p2);
//        while ((len = fis3.read(buffer)) != -1) {
////            sb.append(new String(buffer, 0, len));
//            baos.write(buffer,0,len);
//        }
//        baos.flush();
        int p3 = baos.toByteArray().length;
        System.arraycopy(baos.toByteArray(), 0, data, p2 + 1, p3);
        baos.write(baos.toByteArray(), 0, baos.toByteArray().length);
        System.out.println(baos.toByteArray().length);
        baos.flush();
        System.out.println(baos.toByteArray().length);
        baos.writeTo(new FileOutputStream(new File("E:\\桌面\\mergebyte.pdf")));
        baos.close();
//        fis3.close();
//        fis2.close();
        fis1.close();
        System.out.println("over");
    }

    @Test
    public void mergeFileNio() throws IOException {
        String resultPath = "E:\\桌面\\mergeFileNio.pdf";
        File resultFile = new File(resultPath);
        if (!resultFile.exists()) {
            resultFile.createNewFile();
        }
        String[] fpaths = new String[]{"E:\\temp\\wechat\\WeChat Files\\wxid_572olvzu56xy22\\FileStorage\\File\\2021-01\\使用PDF创建合同 (1).pdf",
                "E:\\temp\\wechat\\WeChat Files\\wxid_572olvzu56xy22\\FileStorage\\File\\2021-01\\使用PDF创建合同 (2).pdf",
                "E:\\temp\\wechat\\WeChat Files\\wxid_572olvzu56xy22\\FileStorage\\File\\2021-01\\使用PDF创建合同 (3).pdf"};
        try {
            FileChannel resultFileChannel = new FileOutputStream(resultFile, true).getChannel();
            for (int i = 0; i < fpaths.length; i++) {
                FileChannel blk = new FileInputStream(fpaths[i]).getChannel();
                resultFileChannel.transferFrom(blk, resultFileChannel.size(), blk.size());
                blk.close();
            }
            resultFileChannel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void mergeFile() throws Exception {
        String resultPath = "E:\\桌面\\mergeFileNio123.pdf";
        File resultFile = new File(resultPath);
        if (!resultFile.exists()) {
            resultFile.createNewFile();
        }
//        String[] fpaths = new String[]{"E:\\temp\\wechat\\WeChat Files\\wxid_572olvzu56xy22\\FileStorage\\File\\2021-01\\使用PDF创建合同 (1).pdf",
//                "E:\\temp\\wechat\\WeChat Files\\wxid_572olvzu56xy22\\FileStorage\\File\\2021-01\\使用PDF创建合同 (2).pdf",
//                "E:\\temp\\wechat\\WeChat Files\\wxid_572olvzu56xy22\\FileStorage\\File\\2021-01\\使用PDF创建合同 (3).pdf"};
        String[] fpaths = new String[]{"E:\\temp\\wechat\\WeChat Files\\wxid_572olvzu56xy22\\FileStorage\\File\\2021-01\\使用PDF创建合同 (1).pdf",
                "E:\\temp\\wechat\\WeChat Files\\wxid_572olvzu56xy22\\FileStorage\\File\\2021-01\\使用PDF创建合同 (2).pdf"};
        try {
            int bufSize = 1024;
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(resultFile));
            byte[] buffer = new byte[bufSize];

            for (int i = 0; i < fpaths.length; i++) {
                BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fpaths[i]));
                int readcount;
                while ((readcount = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, readcount);
                }
                inputStream.close();
            }
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * pdf合并
     *
     * @param inputStreams 要合并的pdf的InputStream数组
     * @return 合并后的pdf的二进制内容
     */
    @Test
    public void mergePdfFiles() throws IOException {
        String resultPath = "E:\\桌面\\mergePdfFiles.pdf";
        File resultFile = new File(resultPath);
        if (!resultFile.exists()) {
            resultFile.createNewFile();
        }
        List<InputStream> inputStreams = new ArrayList<>();
        inputStreams.add(new FileInputStream("E:\\temp\\wechat\\WeChat Files\\wxid_572olvzu56xy22\\FileStorage\\File\\2021-01\\使用PDF创建合同 (1).pdf"));
        inputStreams.add(new FileInputStream("E:\\temp\\wechat\\WeChat Files\\wxid_572olvzu56xy22\\FileStorage\\File\\2021-01\\使用PDF创建合同 (2).pdf"));
        inputStreams.add(new FileInputStream("E:\\temp\\wechat\\WeChat Files\\wxid_572olvzu56xy22\\FileStorage\\File\\2021-01\\使用PDF创建合同 (3).pdf"));
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(resultFile));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Document document = new Document();// 创建一个新的PDF
        byte[] pdfs = new byte[0];
        try {
            PdfCopy copy = new PdfCopy(document, bos);
            document.open();
            for (InputStream is : inputStreams) {// 取出单个PDF的数据
                PdfReader reader = new PdfReader(InputStream2byte(is));
                int pageTotal = reader.getNumberOfPages();
//                logger.info("pdf的页码数是 ==> {}",pageTotal);
                for (int pageNo = 1; pageNo <= pageTotal; pageNo++) {
                    document.newPage();
                    PdfImportedPage page = copy.getImportedPage(reader, pageNo);
                    copy.addPage(page);
                }
                reader.close();
            }
            document.close();
            pdfs = bos.toByteArray();
            outputStream.write(pdfs, 0, pdfs.length);
            bos.close();
            copy.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }


    public byte[] InputStream2byte(InputStream inputStream) {
        byte[] buffer = new byte[0];
        try (InputStream fis = inputStream;
             ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            buffer = bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer;
    }
}
