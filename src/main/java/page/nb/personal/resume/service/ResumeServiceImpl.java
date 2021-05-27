package page.nb.personal.resume.service;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class ResumeServiceImpl implements ResumeService {

    @Value("${nb.resume.location}")
    private String resumeLocation;

    @Override
    public byte[] getResume() {
        DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();
        Resource resume = defaultResourceLoader.getResource("classpath:" + getResumeLocation());
        try {
            byte[] fileContents = FileUtils.readFileToByteArray(resume.getFile());
            return fileContents;
        } catch (Exception e) {

        }
        return new byte[0];
    }

    public String getResumeLocation() {
        return resumeLocation;
    }

    public void setResumeLocation(String resumeLocation) {
        this.resumeLocation = resumeLocation;
    }
}
