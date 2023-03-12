package id.kawahedukasi.dto;

import javax.ws.rs.FormParam;

public class FileRequestDTO {
    @FormParam("file")
    public byte[] file;
}
