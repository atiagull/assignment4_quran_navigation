package com.example.assignment4_quran_navigation;

import androidx.annotation.Nullable;

import java.util.Objects;

public class SurahNumberAndNames implements Comparable<SurahNumberAndNames>{
        String surahName;
        int surahNumber;
    SurahNumberAndNames(String surahName, int surahNumber)
    {
        this.surahName = surahName;
        this.surahNumber = surahNumber;
    }
    public int getSurahNumber()
    {
        return this.surahNumber;
    }
    public String getSurahName()
    {
        return  this.surahName;
    }
    public void setSurahName(String surahName)
    {
        this.surahName = surahName;
    }
    public void setSurahNumber(int surahNumber)
    {
        this.surahNumber = surahNumber;
    }

    @Override
    public String toString() {
        return "SurahNumberAndNames{" +
                "surahName='" + surahName + '\'' +
                ", surahNumber='" + surahNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SurahNumberAndNames)) return false;
        SurahNumberAndNames that = (SurahNumberAndNames) o;
        return getSurahNumber() == that.getSurahNumber() && getSurahName().equals(that.getSurahName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSurahName(), getSurahNumber());
    }

    @Override
    public int compareTo(SurahNumberAndNames o) {
        return this.surahNumber-o.surahNumber;
    }
}
