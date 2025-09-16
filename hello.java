import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class S3Upload {
    public static void main(String[] args) {
        try {
            // Create a text file with "hello"
            File file = new File("hello.txt");
            FileWriter writer = new FileWriter(file);
            writer.write("hello");
            writer.close();

            // Initialize Amazon S3 client
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                                                    .build();

            // Specify your bucket name
            String bucketName = "upload-to-s3-with-codebuild-test";
            
            // Upload the file
            PutObjectRequest request = new PutObjectRequest(bucketName, "hello.txt", file);
            s3Client.putObject(request);

            System.out.println("File uploaded successfully!");

            // Clean up - delete local file
            file.delete();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
