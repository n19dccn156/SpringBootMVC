package KhanhVySang.demo.Service;


import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import KhanhVySang.demo.Model.GoogleDriveFileDTO;


public interface IGoogleDriveFile {
    List<GoogleDriveFileDTO> getAllFile() throws IOException, GeneralSecurityException;
    void deleteFile(String id) throws Exception;
    void uploadFile(MultipartFile file, String filePath, boolean isPublic);
    void downloadFile(String id, OutputStream outputStream) throws IOException, GeneralSecurityException;
}
