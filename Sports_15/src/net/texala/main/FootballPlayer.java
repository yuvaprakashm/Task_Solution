package net.texala.main;

class FootballPlayer extends Player {
    private int jerseyno;

    public FootballPlayer(String name, int jerseyno) {
        super(name, jerseyno);
        this.jerseyno = jerseyno;
    }

    public void play() {
        System.out.println("Football Player - " + getName() + " is playing Football and Jersey Number is " + jerseyno);
    }
}