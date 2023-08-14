class Player{
    private String name;
    private PieceType piecetype;

    Player(String name, PieceType piecetype){
         this.name = name;
         this.piecetype = piecetype;
    }
    public String getName(){
       return this.name;
    }
    public PieceType getPieceType(){
        return this.piecetype;
    }
}