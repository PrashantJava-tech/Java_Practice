package com.pk.string;

public class SubstringTest {

	public static void main(String[] args) {
		
		String zipFileName= "CS_CLNLTR_24206_1721851236714";
		String key="CS/DMC/print/outbound/CLNLTR/CS_CLNLTR_24206_1721851236714.xml";
        String l1 = key.substring(0, key.lastIndexOf("."));
        System.out.println("zipUploadsToNewTemp, l1-->"+l1);
        String documentFolderkey = key.substring(0, key.lastIndexOf("/")) + "/" + zipFileName + ".zip";
        System.out.println("zipUploadsToNewTemp, before calling uploadToS3(). documentFolderkey-->"+documentFolderkey);
        
        
        String key1 = key.substring(0,key.lastIndexOf("/"));
        System.out.println("key1-->"+key1);

        //List<String> keys = awsS3Service.getKeyFromDirectory(bucketName, key + "/", "delete");

	}
}
