package net.texala.main;

class Player {
    private String name;
    private int jerseyno;

    public Player(String name, int jerseyno) {
        this.name = name;
        this.jerseyno = jerseyno;
    }

    public void play() {
        System.out.println(name + " is playing and  Jersey Number is " + jerseyno);
    }

    public String getName() {
        return name;
    }

    public int getJerseyno() {
        return jerseyno;
    }
}

