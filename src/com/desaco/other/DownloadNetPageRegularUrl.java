//package com.desaco.other;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.UnsupportedEncodingException;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.net.URLEncoder;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
///**
// * http://blog.csdn.net/wangcunhuazi/article/details/46287709
// * 
// * ������ҳ��������������ʽ��ȡͼƬ��ַ
// * 
// * @author desaco
// *
// */
//public class DownloadNetPageRegularUrl {
//	//��Դ���ڵ���ҳ��ַ  
//    private static String resourceURL = "http://www.csdn.net/";   
//    //��Դ����֮�󣬱����ڱ��ص��ļ�·��  
//    private static String downloadFilePath = "F://picture/";  
//      
//    /** 
//     *  
//     * ����ͼƬ��������ַ����ͼƬ������Ӳ�̵�filePath 
//     * @param filePath ���ر���ͼƬ���ļ�·�� 
//     * @param imgUrl ͼƬ��������ַ 
//     * @throws UnsupportedEncodingException  
//     *  
//     */  
//    public static void downImages(String filePath,String imgUrl) throws UnsupportedEncodingException {  
//          
//        //ͼƬurl�е�ǰ�沿�֣�����"http://images.csdn.net/"  
//        String beforeUrl = imgUrl.substring(0,imgUrl.lastIndexOf("/")+1);  
//        //ͼƬurl�еĺ��沿�֣����硰20150529/PP6A7429_����1.jpg��  
//        String fileName = imgUrl.substring(imgUrl.lastIndexOf("/")+1);  
//        //����֮���fileName���ո�����ַ�"+"  
//        String newFileName = URLEncoder.encode(fileName, "UTF-8");  
//        //�ѱ���֮���fileName�е��ַ�"+"���滻ΪUTF-8�еĿո��ʾ��"%20"  
//        newFileName = newFileName.replaceAll("\\+", "\\%20");  
//        //����֮���url  
//        imgUrl = beforeUrl + newFileName;  
//          
//        try {  
//            //�����ļ�Ŀ¼  
//            File files = new File(filePath);  
//            if (!files.exists()) {  
//                files.mkdirs();  
//            }  
//            //��ȡ���ص�ַ  
//            URL url = new URL(imgUrl);  
//            //���������ַ  
//            HttpURLConnection connection = (HttpURLConnection)url.openConnection();  
//            //��ȡ���ӵ������  
//            InputStream is = connection.getInputStream();  
//            //�����ļ���fileNameΪ����֮ǰ���ļ���  
//            File file = new File(filePath + fileName);  
//            //����������д���ļ�  
//            FileOutputStream out = new FileOutputStream(file);  
//            int i = 0;  
//            while((i = is.read()) != -1){  
//                out.write(i);  
//            }  
//            out.close();  
//            is.close();  
//        } catch (Exception e) {  
//            e.printStackTrace();  
//        }  
//    }  
//      
//    public static void main(String[] args) throws IOException {  
//                  
//            //��һ����վ��ȡ�ͽ���һ��HTML�ĵ���jsoup��API���д˷�����˵��  
//            Document document = Jsoup.connect(resourceURL).get();  
//            //System.out.println(document);  
//            //��ȡ���е�img��ǩ  
//            Elements elements = document.getElementsByTag("img");  
//            for(Element element : elements){  
//                //��ȡÿ��img��ǩ��src���Ե����ݣ���ͼƬ��ַ����"abs:"��ʾ����·��  
//                String imgSrc = element.attr("abs:src");  
//                //����ͼƬ�ļ������Եı���Ӳ����  
//                System.out.println("��������ͼƬ��-----------" + imgSrc);  
//                downImages(downloadFilePath, imgSrc);  
//                System.out.println("ͼƬ������ϣ�-----------" + imgSrc);  
//                System.out.println("-------------------------------------------------------------------------------------------------------------");  
//            }  
//            System.out.println("�������� " + elements.size() +" ���ļ�(��ȥ��)");  
//    }  
//}
