DROP  TABLE IF EXISTS MP3 ;
CREATE TABLE MP3(
   ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
   NAME           TEXT    NOT NULL,
   AUTHOR         INT     NOT NULL
);

INSERT INTO MP3 (NAME,AUTHOR) VALUES ( 'Prodigy', 'Diesel power'  );
INSERT INTO MP3 (NAME,AUTHOR) VALUES ( 'Rammstein', 'Reise, reise'  );