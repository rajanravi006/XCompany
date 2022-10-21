package com.crio.xcompany;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("XcompanyApplication Tests")
public class XcompanyApplicationTests {


    // TODO: WARNING!!!
    //  DO NOT MODIFY ANY FILES IN THE TESTS/ ASSESSMENTS UNLESS ASKED TO.
    //  Any modifications in this file may result in Assessment failure!
    
    @Test
    public void XcompanyApplication_assessment() throws IOException{
        // Arrange
        Path inputFile = Paths.get("src","test","resources","sample_input.txt");
        Path actualOutputFile = Paths.get("src","test","resources","actual_output.txt");
        Path expectedOutputFile = Paths.get("src","test","resources","sample_output.txt");
        // Act
        XcompanyApplication.run(inputFile.toString(),actualOutputFile.toString());
        // Assert
        Assertions.assertTrue(compareByMemoryMappedFiles(expectedOutputFile,actualOutputFile));
    }

    // https://www.baeldung.com/java-compare-files
    public boolean compareByMemoryMappedFiles(Path path1, Path path2) throws IOException {
        try (RandomAccessFile randomAccessFile1 = new RandomAccessFile(path1.toFile(), "r"); 
             RandomAccessFile randomAccessFile2 = new RandomAccessFile(path2.toFile(), "r")) {
            
            FileChannel ch1 = randomAccessFile1.getChannel();
            FileChannel ch2 = randomAccessFile2.getChannel();
            if (ch1.size() != ch2.size()) {
                return false;
            }
            long size = ch1.size();
            MappedByteBuffer m1 = ch1.map(FileChannel.MapMode.READ_ONLY, 0L, size);
            MappedByteBuffer m2 = ch2.map(FileChannel.MapMode.READ_ONLY, 0L, size);
    
            return m1.equals(m2);
        }
    }
}
