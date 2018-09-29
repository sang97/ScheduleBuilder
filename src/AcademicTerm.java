/**
 * Use to represent academic term like Spring 2018, Fall 2018
 * 
 * @author Sang Nguyen
 *
 */
public class AcademicTerm implements Comparable<AcademicTerm> {
    private String season;
    private Integer year;


    public AcademicTerm(String newSeason, int newYear) {
        season = newSeason;
        year = newYear;
    }


    public String getSeason() {
        return season;
    }


    public void setSeason(String season) {
        this.season = season;
    }


    public Integer getYear() {
        return year;
    }


    public void setYear(Integer year) {
        this.year = year;
    }


    @Override
    public int compareTo(AcademicTerm other) {
        // TODO Auto-generated method stub
        int yearComp = this.year.compareTo(other.getYear());
        
        return (yearComp == 0)? -(this.season.compareTo(other.getSeason())) : yearComp;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((season == null) ? 0 : season.hashCode());
        result = prime * result + ((year == null) ? 0 : year.hashCode());
        return result;
    }
 

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AcademicTerm other = (AcademicTerm)obj;
        if (season == null) {
            if (other.season != null)
                return false;
        }
        else if (!season.equals(other.season))
            return false;
        if (year == null) {
            if (other.year != null)
                return false;
        }
        else if (!year.equals(other.year))
            return false;
        return true;
    }
    
    

}
