package e3;

import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

class Recording {
    private final String id;

    public Recording(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recording recording = (Recording) o;
        return Objects.equals(id, recording.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

class Track {
    private final int position;
    private final int duration;
    private final Recording recording;

    public Track(int position, int duration, Recording recording) {
        this.position = position;
        this.duration = duration;
        this.recording = recording;
    }

    public int getPosition() {
        return position;
    }

    public int getDuration() {
        return duration;
    }

    public Recording getRecording() {
        return recording;
    }

    @Override
    public String toString() {
        return "Position: " + position + ", Duration: " + duration + ", Recording: " + recording.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return position == track.position &&
                duration == track.duration &&
                Objects.equals(recording, track.recording);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, duration, recording);
    }
}


class Release {
    private final String id;
    private final String title;
    private final String artist;
    private final Set<Track> tracklist;

    public Release(String id, String title, String artist) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.tracklist = new HashSet<>();
    }

    public String setId() {
        return id;
    }

    public String setTitle() {
        return title;
    }

    public String setArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        tracklist.add(track);
    }

    public Set<Track> setTracklist() {
        return new HashSet<>(tracklist);
    }

    public void removeTrack(Track track) {
        tracklist.remove(track);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Release release = (Release) o;
        return Objects.equals(id, release.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}