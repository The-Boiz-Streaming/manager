CREATE TABLE IF NOT EXISTS artist (
    id UUID PRIMARY KEY,
    name VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS release (
    id UUID PRIMARY KEY,
    artist_id UUID NOT NULL REFERENCES artist (id),
    release_type VARCHAR NOT NULL,
    name VARCHAR NOT NULL,
    release_year SMALLINT NOT NULL
);

CREATE TABLE IF NOT EXISTS track (
     id UUID PRIMARY KEY,
     release_id UUID NOT NULL REFERENCES release (id),
     name VARCHAR NOT NULL,
     duration INT NOT NULL,
     track_number SMALLINT NOT NULL,  --- порядковый номер трека в альбоме
     file_id UUID NOT NULL
);
