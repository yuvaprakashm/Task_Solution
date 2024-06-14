package net.texala.main;

class CricketPlayer extends Player {
    private int jerseyno;

    public CricketPlayer(String name, int jerseyno) {
        super(name, jerseyno);
        this.jerseyno = jerseyno;
    }

    public void play() {
        System.out.println("Cricket Player - " + getName() + " is playing Cricket and Jersey Number is " + jerseyno);
    }

	
}