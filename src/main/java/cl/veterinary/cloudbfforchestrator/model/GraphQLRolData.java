package cl.veterinary.cloudbfforchestrator.model;



import java.util.List;


public class GraphQLRolData {

    private List<Rol>getAllRoles;
    private Rol getRolById;
    private Rol saveRol;
    private Rol updateRol;
    private String deleteRol;

    public List<Rol> getGetAllRoles() {
        return getAllRoles;
    }

    public void setGetAllRoles(List<Rol> getAllRoles) {
        this.getAllRoles = getAllRoles;
    }

    public Rol getGetRolById() {
        return getRolById;
    }

    public void setGetRolById(Rol getRolById) {
        this.getRolById = getRolById;
    }

    public Rol getSaveRol() {
        return saveRol;
    }

    public void setSaveRol(Rol saveRol) {
        this.saveRol = saveRol;
    }

    public Rol getUpdateRol() {
        return updateRol;
    }

    public void setUpdateRol(Rol updateRol) {
        this.updateRol = updateRol;
    }

    public String getDeleteRol() {
        return deleteRol;
    }

    public void setDeleteRol(String deleteRol) {
        this.deleteRol = deleteRol;
    }
}
