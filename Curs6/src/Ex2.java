public class Ex2 {

    public static void main(String[] args){
        Premiu oscar1990 = new Premiu("oscar", 1990);
        Premiu oscar2000 = new Premiu("oscar", 2000);
        Premiu oscar2010 = new Premiu("oscar", 2010);
        Premiu oscar2018 = new Premiu("oscar", 2018);

        Actor actorOscar1990 = new Actor("actor cu 2 oscaruri", 35,new Premiu[] {oscar1990, oscar2000});
        Actor actorOscar2010 = new Actor("actor cu oscar din 2010", 55,new Premiu[] {oscar2010});
        Actor actorOscar2018 = new Actor("actor cu oscar din 2018", 23,new Premiu[] {oscar2018});
        Actor actorFaraPremii01 = new Actor("actor cu oscar din 2010", 33,new Premiu[] {});
        Actor actorFaraPremii02 = new Actor("actor cu oscar din 2010", 60,new Premiu[] {});
        Actor actorFaraPremii03 = new Actor("actor cu oscar din 2010", 20,new Premiu[] {});

        Film film1 = new Film(1990, "film cu actori de oscar",new Actor[] {actorOscar1990, actorFaraPremii01});
        Film film2 = new Film(2010, "film cu actori fara premii2",new Actor[] {actorFaraPremii01, actorFaraPremii02, actorFaraPremii03});
        Film film3 = new Film(2010, "film cu actori fara premii3",new Actor[] {actorFaraPremii01, actorFaraPremii02, actorFaraPremii03});
        Film film4 = new Film(2018, "film cu actori de oscar",new Actor[] {actorOscar2010, actorOscar2018, actorFaraPremii02});
        Film film5 = new Film(2018, "film cu actori fara premii5",new Actor[] {actorFaraPremii02, actorFaraPremii03});

        Studio studio1 = new Studio("MGM", new Film[] {film1, film2});
        Studio studio2 = new Studio("Disney", new Film[] {film3, film4, film5});

        Studio[] studioDatabase = new Studio[]{studio1, studio2};

        System.out.print("Studios with more than 2 films: ");

        for(Studio studio: studioDatabase){
            if(studio.getFilme().length >= 2){
                System.out.print(studio.getNume() + ' ');
            }
        }

        System.out.print("\nThe studio in which plays the actor with name `actor cu 2 oscaruri` is ");

        for(Studio studio: studioDatabase){
            for(Film film: studio.getFilme()){
                for(Actor actor: film.getActori()){
                    if (actor.getNume().equals("actor cu 2 oscaruri")){
                        System.out.print(studio.getNume());
                    }
                }
            }
        }

        System.out.println("\nThe movies with actors above 50 are ");

        for(Studio studio: studioDatabase){
            for(Film film: studio.getFilme()){
                for(Actor actor: film.getActori()){
                    if(actor.getVarsta() >= 50){
                        System.out.print(film.getNume() + ' ');
                    }
                }
            }
        }
    }

}

class Premiu{
    private String nume;
    private Integer an;

    public Premiu(String name, Integer an){
        this.nume = name;
        this.an = an;
    }

    public String getNume() {
        return nume;
    }

    public Integer getAn() {
        return an;
    }
}

class Actor{
    private String nume;
    private Integer varsta;
    private Premiu[] premii;


    public Actor(String name, Integer age, Premiu[] awards){
        this.nume = name;
        this.varsta = age;
        this.premii = awards;
    }

    public String getNume() {
        return nume;
    }

    public Integer getVarsta() {
        return varsta;
    }

    public Premiu[] getPremii() {
        return premii;
    }
}

class Film{
    private Integer an_aparitie;
    private String nume;
    private Actor[] actori;

    public Film(Integer an_aparitie, String nume, Actor[] actori){
        this.an_aparitie = an_aparitie;
        this.nume = nume;
        this.actori = actori;

    }

    public String getNume() {
        return nume;
    }

    public Actor[] getActori() {
        return actori;
    }

    public Integer getAn_aparitie() {
        return an_aparitie;
    }
}

class Studio{
    private String nume;
    private Film[] filme;

    public Studio(String nume, Film[] filme){
        this.nume = nume;
        this.filme = filme;
    }

    public String getNume() {
        return nume;
    }

    public Film[] getFilme() {
        return filme;
    }
}
