package cl.veterinary.cloudbfforchestrator.model;



import java.util.List;


public class GraphQLData {

    private List<Rol>getAllRoles;
    private Rol getRolById;
    private Rol saveRol;
    private Rol updateRol;
    private String deleteRol;

    private List<User>findAll;
    private User findUserById;
    private User saveUser;
    private User updateUser;
    private String deleteUser;

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

    public List<User> getFindAll() {
        return findAll;
    }

    public void setFindAll(List<User> findAll) {
        this.findAll = findAll;
    }

    public User getFindUserById() {
        return findUserById;
    }

    public void setFindUserById(User findUserById) {
        this.findUserById = findUserById;
    }

    public User getSaveUser() {
        return saveUser;
    }

    public void setSaveUser(User saveUser) {
        this.saveUser = saveUser;
    }

    public User getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(User updateUser) {
        this.updateUser = updateUser;
    }

    public String getDeleteUser() {
        return deleteUser;
    }

    public void setDeleteUser(String deleteUser) {
        this.deleteUser = deleteUser;
    }
}
