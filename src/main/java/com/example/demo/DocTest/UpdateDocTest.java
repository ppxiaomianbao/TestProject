package com.example.demo.DocTest;



import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.usermodel.*;

import javax.swing.text.Document;
import java.awt.*;
import java.io.*;
import java.text.Format;
import java.util.*;

public class UpdateDocTest {


       /* public static void main (String[] objects) throws IOException {
            FileInputStream in = null;
            try {
                in = new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\新建 DOC 文档.doc"));
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            HWPFDocument hdt = null;
            try {
                hdt = new HWPFDocument(in);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            Fields fields = hdt.getFields();
            StringBuilder text1 = hdt.getText();
            System.out.println(text1.toString());
            Range range = hdt.getRange();
            String text = range.text();
            String[] split = text.split("“");
            for(int i=0; i<split.length; i++){
                String str = split[i];
                int c = ss(str);
                String rep = str.substring(c,str.length());
                boolean b =false;
                if(rep.indexOf("白少景")!=-1||rep.indexOf("龙泽野")!=-1||rep.indexOf("龙爷越")!=-1||rep.indexOf("大一")!=-1||rep.indexOf("陆思远")!=-1||rep.indexOf("萧辰逸")!=-1){
                    b = true;
                }
                str = str.substring(0,c);
                if(b){
                    System.err.println(str);
                    range.replaceText("$"+str,"$"+str+"!!!");
                }

            }
            System.out.println(text);

        }

        private static int ss(String str){
            if(str.indexOf("”")!=-1){
                return str.indexOf("”");
            }else if(str.indexOf("。")!=-1){
                return str.indexOf("。");
            }else if(str.indexOf("？")!=-1){
                return str.indexOf("？");
            }else if(str.indexOf("！")!=-1){
                return str.indexOf("！");
            }else{
                return 0;
            }
        }

    public static void readAndWriterTest3() throws IOException {
        File file = new File("C:\\Users\\Administrator\\Desktop\\新建 DOC 文档.doc");
        String str = "";
        try {
            FileInputStream fis = new FileInputStream(file);
            HWPFDocument doc = new HWPFDocument(fis);
            String doc1 = doc.getDocumentText();
            System.out.println(doc1);
            StringBuilder doc2 = doc.getText();
            System.out.println(doc2);
            Range rang = doc.getRange();
            String doc3 = rang.text();
            System.out.println(doc3);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public static void main(String[] objects) throws Exception {

        FileInputStream in = new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\新建 DOC 文档.doc"));
        HWPFDocument doc = new HWPFDocument(in);
        Range range = doc.getRange();
        range.replaceText("小","大二");
        String text = range.text();
        FileOutputStream os = new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\新建 DOC 文档1.doc"));
        ByteArrayOutputStream ostream = new ByteArrayOutputStream();
        FileOutputStream out = null;
        //String path = "f:\\"+fileName;
            out = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\新建 DOC 文档1.doc", true);
            doc.write(ostream);
        // 输出字节流
        try {
            out.write(ostream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ostream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        testSimpleWrite();
    }


    public static void testSimpleWrite() throws Exception {
        //新建一个文档
        XWPFDocument doc = new XWPFDocument();
        //创建一个段落
        XWPFParagraph para = doc.createParagraph();

        //一个XWPFRun代表具有相同属性的一个区域。
        XWPFRun run = para.createRun();
        run.setBold(true); //加粗
        run.setText("加粗的内容");
        run = para.createRun();
        run.setColor("FF0000");
        run.setText("红色的字。");
        OutputStream os = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\新建 DOC 文档5.doc");
        //把doc输出到输出流
        doc.write(os);
        os.close();
    }

    /**
     * Info 将docx的文档的内容把指定的内容替换掉
     * Modification History:
     * Date         Author      Version     Description
     * -----------------------------------------------------------------
     * 2018-1-5        ywl       v1.0.0       create
     * -----------------------------------------------------------------
     * @param srcPath 原路径
     * @param destPath 保存路径
     * @map key为需要替换的 value为替换的内容
     */
    public static void searchAndReplace(String srcPath, String destPath, Map<String, String> map) {
        FileOutputStream outStream = null;
        InputStream is = null;
        try {
            /*URL url = new URL(srcPath);
            is = url.openStream();*/
            is = new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\新建 DOC 文档.doc"));
            XWPFDocument document = new XWPFDocument(is);
            /**
             * 替换段落中的指定文字
             */
            Iterator<XWPFParagraph> itPara = document.getParagraphsIterator();
            while (itPara.hasNext()) {
                XWPFParagraph paragraph = (XWPFParagraph) itPara.next();
                Set<String> set = map.keySet();
                Iterator<String> iterator = set.iterator();
                while (iterator.hasNext()) {
                    String key = iterator.next();
                    java.util.List<XWPFRun> run = paragraph.getRuns();
                    for(int i=0;i<run.size();i++)
                    {
                        if(run.get(i).getText(run.get(i).getTextPosition())!=null &&
                                run.get(i).getText(run.get(i).getTextPosition()).contains(key))
                        {
                            /**
                             * 参数0表示生成的文字是要从哪一个地方开始放置,设置文字从位置0开始
                             * 就可以把原来的文字全部替换掉了
                             */
                            String text = run.get(i).getText(run.get(i).getTextPosition());
                            text = text.replaceAll(key,map.get(key));
                            run.get(i).setText(text,0);
                        }
                    }
                }
            }

            /**
             * 替换表格中的指定文字
             */
            Iterator<XWPFTable> itTable = document.getTablesIterator();
            while (itTable.hasNext()) {
                XWPFTable table = (XWPFTable) itTable.next();
                int count = table.getNumberOfRows();
                for (int i = 0; i < count; i++) {
                    XWPFTableRow row = table.getRow(i);
                    java.util.List<XWPFTableCell> cells = row.getTableCells();
                    for (XWPFTableCell cell : cells) {
                        for (Map.Entry<String, String> e : map.entrySet()) {
                            if (cell.getText().equals(e.getKey())) {
                                cell.removeParagraph(0);
                                cell.setText(e.getValue());
                            }
                        }
                    }
                }
            }
            outStream = new FileOutputStream(destPath);
            document.write(outStream);
//            URLConnection conn = url.openConnection();
//            conn.setDoOutput(true);
//            outStream = conn.getOutputStream();
//            document.write(outStream);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(null != is){
                    is.close();
                }
                if(null != outStream){
                    outStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
