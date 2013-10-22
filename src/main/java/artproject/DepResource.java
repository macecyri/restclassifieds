package artproject;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;

import artproject.dao.ArtDao;
import artproject.model.Dep;


@Path("/deps")
@Data
public class DepResource {

	@Autowired
    private ArtDao artDao;
	
   @GET
   @Produces("application/json")
    public List<Dep> getDeps(){
        return artDao.getAllDeps();
    }
}
