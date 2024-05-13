package com.jsp.entity;

import java.util.List;
import java.util.Objects;

public class Dancer {
    public enum DanceLevel {
        BEGINNER("초보", 50000),
        AMATEUR("아마추어", 100000),
        PROFESSIONAL("프로페셔널", 200000)
        ;
        private final String levelDescription; // 레벨 설명
        private final int payPerEvent; // 공연당 페이

        DanceLevel(String levelDescription, int payPerEvent) {
            this.levelDescription = levelDescription;
            this.payPerEvent = payPerEvent;
        }

        public String getLevelDescription() {
            return levelDescription;
        }

        public int getPayPerEvent() {
            return payPerEvent;
        }
    }

    public enum Genre {
        HIPHOP("힙합"),
        STREET("스트릿"),
        KPOP("케이팝"),

        ;


        private final String genreDescription; // 장르 설명

        Genre(String genreDescription) {
            this.genreDescription = genreDescription;
        }

        public String getGenreDescription() {
            return genreDescription;
        }
    }
    private int id;       // 댄서 식별값

    private String name; // 댄서 이름

    private String crewName; // 댄서 팀 이름

    private DanceLevel danceLevel; // 댄서 실력 등급
    //체크박스라 여러개 되도록 함
    private List<Genre> genres; // 댄서의 장르리스트


    public Dancer() {
    }

    public Dancer(String name, String crewName, DanceLevel danceLevel, List<Genre> genres) {
        this.name = name;
        this.crewName = crewName;
        this.danceLevel = danceLevel;
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCrewName() {
        return crewName;
    }

    public void setCrewName(String crewName) {
        this.crewName = crewName;
    }

    public DanceLevel getDanceLevel() {
        return danceLevel;
    }

    public void setDanceLevel(DanceLevel danceLevel) {
        this.danceLevel = danceLevel;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dancer dancer = (Dancer) o;
        return Objects.equals(name, dancer.name) && Objects.equals(crewName, dancer.crewName) && danceLevel == dancer.danceLevel && Objects.equals(genres, dancer.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, crewName, danceLevel, genres);
    }

    @Override
    public String toString() {
        return "Dancer{" +
                "name='" + name + '\'' +
                ", crewName='" + crewName + '\'' +
                ", danceLevel=" + danceLevel +
                ", genres=" + genres +
                '}';
    }
}
