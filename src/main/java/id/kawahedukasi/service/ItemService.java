package id.kawahedukasi.service;

import id.kawahedukasi.model.Item;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class ItemService {

    public Response get(){
        return Response.status(Response.Status.OK).entity(Item.findAll().list()).build();
    }

    public Response getById(Long id){
        Item item = Item.findById(id);
        if (item == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.status(Response.Status.OK).entity(Item.find("id = ?1", item.id).list()).build();
    }

    @Transactional
    public Response post(Map<String, Object> request){
        Item item = new Item();
        item.name = request.get("name").toString();
        item.count = Integer.parseInt(request.get("count").toString());
        item.price = Double.parseDouble(request.get("price").toString());
        item.type = request.get("type").toString();
        item.description = request.get("description").toString();

        //savedata
        item.persist();

        return Response.status(Response.Status.CREATED).entity(new HashMap<>()).build();
    }


    @Transactional
    public Response put(Long id, Map<String, Object> request){
        Item item = Item.findById(id);
        if(item == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        item.name = request.get("name").toString();
        item.count = Integer.parseInt(request.get("count").toString());
        item.price = Double.parseDouble(request.get("price").toString());
        item.type = request.get("type").toString();
        item.description = request.get("description").toString();

        //savedata
        item.persist();

        return Response.status(Response.Status.CREATED).entity(new HashMap<>()).build();
    }

    @Transactional
    public Response delete(Long id){
        Item item = Item.findById(id);
        if(item == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        //deletedata
        item.delete();

        return Response.status(Response.Status.CREATED).entity(new HashMap<>()).build();
    }
}
