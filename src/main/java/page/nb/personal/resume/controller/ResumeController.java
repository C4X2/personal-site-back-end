package page.nb.personal.resume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import page.nb.personal.resume.service.ResumeService;

/**
 * @author Nate B.
 * @version 1.0
 */
@Controller
public class ResumeController {

    public static final String RESUME_DOCX = "Resume.docx";

    @Autowired
    private ResumeService resumeService;

    @RequestMapping(value = "/resume", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getResume() {
        byte[] data = getResumeService().getResume();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //set the actual filename of your docx
        headers.setContentDispositionFormData(RESUME_DOCX, RESUME_DOCX);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

        ResponseEntity<byte[]> response = new ResponseEntity<>(data, headers, HttpStatus.OK);
        return response;
    }

    public ResumeService getResumeService() {
        return resumeService;
    }

    public void setResumeService(ResumeService resumeService) {
        this.resumeService = resumeService;
    }
}
