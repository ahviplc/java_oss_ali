package oss.java;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;

/*
 * LC
 * 2017-9-28 12:08:44
 */

public class oss_demo {
	
	
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		
		
		// endpoint以杭州为例，其它region请按实际情况填写
		String endpoint = "oss-cn-shanghai.aliyuncs.com";
		// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建
		String accessKeyId = "#";
		String accessKeySecret = "#";
		// 创建OSSClient实例
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		
		
		
		// 创建bucket
//		String bucketName = "lc-img2";
//		ossClient.createBucket(bucketName);
		
		// 列举bucket
		List<Bucket> buckets = ossClient.listBuckets();
		for (Bucket bucket : buckets) {
		    System.out.println(" - " + bucket.getName());
		}
		
		
		// 删除bucket
		//ossClient.deleteBucket("<bucketName>");
		
		
		String bucketName = "lc-img";
		
		// 删除Object
		ossClient.deleteObject(bucketName, "f-note");
		
		System.out.println("删除成功！");
		
		// 上传字符串
		String content = "Hello OSS";
		ossClient.putObject(bucketName, "hello-lc.txt", new ByteArrayInputStream(content.getBytes()));
		
		System.out.println("上传字符串成功！");
		
		
		// 上传网络流
		InputStream inputStream = new URL("http://www.oneplusone.top").openStream();
		ossClient.putObject(bucketName, "opo-wangluo.txt", inputStream);

		System.out.println("上传网络流成功！");
		
		
		// 上传文件
		ossClient.putObject(bucketName, "f-note.txt", new File("f://note.txt"));

		
		// 读Object内容
		
		OSSObject ossObject = ossClient.getObject(bucketName, "hello-lc.txt");
		System.out.println("Object content:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(ossObject.getObjectContent()));
		while (true) {
		    String line = reader.readLine();
		    if (line == null) break;
		    System.out.println("\n" + line);
		}
		reader.close();
		
		
		// 下载object到文件
		ossClient.getObject(new GetObjectRequest(bucketName, "hello-lc.txt"), new File("f://lc-down.txt"));
		
		ossClient.getObject(new GetObjectRequest(bucketName, "Koala.jpg"), new File("f://考拉.jpg"));

		
		// 关闭client
		ossClient.shutdown();
		
		System.out.println("操作成功！");
		
		
	}
	
	
	

}
