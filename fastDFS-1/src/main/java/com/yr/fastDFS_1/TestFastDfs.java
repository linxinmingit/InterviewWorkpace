//package com.yr.fastDFS_1;
//
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.UUID;
//
//import org.apache.commons.io.IOUtils;
//import org.csource.common.MyException;
//import org.csource.common.NameValuePair;
//import org.csource.fastdfs.ClientGlobal;
//import org.csource.fastdfs.FileInfo;
//import org.csource.fastdfs.StorageClient;
//import org.csource.fastdfs.StorageServer;
//import org.csource.fastdfs.TrackerClient;
//import org.csource.fastdfs.TrackerServer;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//public class TestFastDfs {
//     //刚刚的配置文件位置
//    public String conf_filename = "D:\\MyProject\\fastdfs-demo\\src\\main\\resources\\fdfs_client.conf"; 
//
//     //要上传的文件地址
//    public String local_filename = "C:\\Users\\zxj\\Desktop\\新建文本.txt";
//
//    @Before
//    public void setUp() throws Exception {
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }
//
//    @Test
//    public void testUpload() {
//
//        try { 
//			try {
//	            ClientGlobal.init(conf_filename);
//
//	            TrackerClient tracker = new TrackerClient(); 
//	            TrackerServer trackerServer = tracker.getConnection(); 
//	            StorageServer storageServer = null;
//
//	            StorageClient storageClient = new StorageClient(trackerServer, storageServer); 
////	          NameValuePair nvp = new NameValuePair("age", "18"); 
//	            NameValuePair nvp [] = new NameValuePair[]{ 
//	                    new NameValuePair("age", "18"), 
//	                    new NameValuePair("sex", "male") 
//	            }; 
//	            String fileIds[];
//	            
//				fileIds = storageClient.upload_file(local_filename, "png", nvp);
//	            System.out.println(fileIds.length); 
//	            System.out.println("组名：" + fileIds[0]); 
//	            System.out.println("路径: " + fileIds[1]);
//			} catch (MyException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//        } catch (FileNotFoundException e) { 
//            e.printStackTrace(); 
//        } catch (IOException e) { 
//            e.printStackTrace(); 
//        }
//    }
//
//
//    public void testDownload() {
//        try {
//
//            ClientGlobal.init(conf_filename);
//
//            TrackerClient tracker = new TrackerClient(); 
//            TrackerServer trackerServer = tracker.getConnection(); 
//            StorageServer storageServer = null;
//
//            StorageClient storageClient = new StorageClient(trackerServer, storageServer); 
//            byte[] b = storageClient.download_file("group1", "M00/00/00/wKgRcFV_08OAK_KCAAAA5fm_sy874.conf"); 
//            System.out.println(b); 
//            IOUtils.write(b, new FileOutputStream("D:/"+UUID.randomUUID().toString()+".conf"));
//        } catch (Exception e) { 
//            e.printStackTrace(); 
//        } 
//    }
//
//
//    public void testGetFileInfo(){ 
//        try { 
//            ClientGlobal.init(conf_filename);
//
//            TrackerClient tracker = new TrackerClient(); 
//            TrackerServer trackerServer = tracker.getConnection(); 
//            StorageServer storageServer = null;
//
//            StorageClient storageClient = new StorageClient(trackerServer, storageServer); 
//            FileInfo fi = storageClient.get_file_info("group1", "M00/00/00/wKgRcFV_08OAK_KCAAAA5fm_sy874.conf"); 
//            System.out.println(fi.getSourceIpAddr()); 
//            System.out.println(fi.getFileSize()); 
//            System.out.println(fi.getCreateTimestamp()); 
//            System.out.println(fi.getCrc32()); 
//        } catch (Exception e) { 
//            e.printStackTrace(); 
//        } 
//    } 
//
//
//    public void testGetFileMate(){ 
//        try { 
//            ClientGlobal.init(conf_filename);
//
//            TrackerClient tracker = new TrackerClient(); 
//            TrackerServer trackerServer = tracker.getConnection(); 
//            StorageServer storageServer = null;
//
//            StorageClient storageClient = new StorageClient(trackerServer, 
//                    storageServer); 
//            NameValuePair nvps [] = storageClient.get_metadata("group1", "M00/00/00/wKgRcFV_08OAK_KCAAAA5fm_sy874.conf"); 
//            for(NameValuePair nvp : nvps){ 
//                System.out.println(nvp.getName() + ":" + nvp.getValue()); 
//            } 
//        } catch (Exception e) { 
//            e.printStackTrace(); 
//        } 
//    } 
//
//
//    public void testDelete(){ 
//        try { 
//            ClientGlobal.init(conf_filename);
//
//            TrackerClient tracker = new TrackerClient(); 
//            TrackerServer trackerServer = tracker.getConnection(); 
//            StorageServer storageServer = null;
//
//            StorageClient storageClient = new StorageClient(trackerServer, 
//                    storageServer); 
//            int i = storageClient.delete_file("group1", "M00/00/00/wKgRcFV_08OAK_KCAAAA5fm_sy874.conf"); 
//            System.out.println( i==0 ? "删除成功" : "删除失败:"+i); 
//        } catch (Exception e) { 
//            e.printStackTrace(); 
//        } 
//    }
//}
