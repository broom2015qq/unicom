package demo.service;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class ReadjsonService {
    @Value(value="classpath:data/data.json")
    private Resource data;

    public String getData(){
        try {
            File file = data.getFile();
            long t0 = System.nanoTime();
            String jsonData = this.jsonRead(file);
            long t1 = System.nanoTime();
            long millis = TimeUnit.NANOSECONDS.toMillis(t1-t0);
            System.out.println(millis +"ms");
            return jsonData;
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * 读取文件类容为字符串
     * @param file
     * @return
     */
    private String jsonRead(File file){
        Scanner scanner = null;
        StringBuilder buffer = new StringBuilder();
        try {
            scanner = new Scanner(file, "utf-8");
            while (scanner.hasNextLine()) {
                buffer.append(scanner.nextLine());
            }
        } catch (Exception e) {

        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return buffer.toString();
    }
}
