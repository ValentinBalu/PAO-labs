package examples;

import java.util.Objects;

public class Cat extends Animal{
    private CatBreed catBreed;

    public Cat(String name, String sound, CatBreed catBreed) {
        super(name, sound);
        this.catBreed = catBreed;
    }

    public CatBreed getCatBreed() {
        return catBreed;
    }

    public void setCatBreed(CatBreed catBreed) {
        this.catBreed = catBreed;
    }

    @Override
    public boolean equals(Object o){
        if(this==o){
            return false;
        }
        if(o==null || getClass()!=o.getClass()){
            return false;
        }
        Cat cat = (Cat) o;
        return catBreed == cat.catBreed;
    }
    @Override
    public int hashCode() {return Objects.hash(catBreed);}
}
