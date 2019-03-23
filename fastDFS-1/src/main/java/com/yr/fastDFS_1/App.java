package com.yr.fastDFS_1;

import java.io.FileOutputStream;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;


/**
 * Hello world!
 *
 */
public class App 
{
	
	public String conf_filename = "D:/InterviewWorkpace/fastDFS-1/src/main/resources/fdfs_client.conf"; 
	
    public static void main( String[] args )
    {
//      System.out.println( "Hello World!" );
//    	new App().uploadToDFS();
    	new App().testDownload();
    }
    /**
     * 将文件上传到fdfs存储服务器上
     */
    public void uploadToDFS()
    {
    	try {
    		ClientGlobal.init(conf_filename);
    		// 2.创建一个TrackerClient对象
    		TrackerClient trackerClient = new TrackerClient();
    		// 3.创建一个TrackerServer对象
    		TrackerServer trackerServer = trackerClient.getConnection();
    		// 4.声明一个StorageServer对象，为null
    		StorageServer storageServer = null;
    		// 5.获得StorageClient对象
    		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
    		// 6.直接调用StorageClient对象方法上传文件即可。
    		String[] strs = storageClient.upload_file("E:/my photos/lv/low.jpg", "jpg", null);
    		// 7.可以打印出文件的地址，可以拼成URL访问
    		for (String str : strs) {
    			System.out.println(str);
    		}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
    /**
     * 下载
     */
    public void testDownload() {
        try {

            ClientGlobal.init(conf_filename);

            TrackerClient tracker = new TrackerClient(); 
            TrackerServer trackerServer = tracker.getConnection(); 
            StorageServer storageServer = null;

            StorageClient storageClient = new StorageClient(trackerServer, storageServer); 
//            group1/M00/00/00/wKgBFFxntWyANkAlAAAA1CU0dAw078.txt
            byte[] b = storageClient.download_file("group1", "M00/00/00/wKgBFFxntWyANkAlAAAA1CU0dAw078.txt"); 
            System.out.println(b); 
            IOUtils.write(b, new FileOutputStream("D:/InterviewWorkpace/fastDFS-1/src/main/resources/static/"+UUID.randomUUID().toString()+".txt"));
            System.out.println("下载完成!");
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    }
    
}
