public enum CompileError {
    SockError("Incompatibles types of Socks and Glove"),
    BackwardError("Backwars error");

    private final String description;
    CompileError(String err){
        description = err;
    }

    public String getDescription(){
        return description;
    }
}
