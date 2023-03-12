package id.kawahedukasi.controller;

import id.kawahedukasi.service.MailService;
import net.sf.jasperreports.engine.JRException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Path("/mail")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MailControll {
    @Inject
    MailService mailService;

    @POST
    public Response sendEmail(Map<String, Object> request) throws IOException {
        mailService.sendEmail(request.get("email").toString());
        return Response.ok(new HashMap<>()).build();
    }

    @POST
    @Path("/excel")
    public Response sendExcelEmail(Map<String, Object> request) throws IOException, JRException {
        mailService.sendExcelToEmail(request.get("email").toString());
        return Response.ok(new HashMap<>()).build();
    }
}
