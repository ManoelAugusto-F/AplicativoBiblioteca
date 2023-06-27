"CREATE TABLE IF NOT EXISTS livros (" +
                "  ID bigint(20) NOT NULL AUTO_INCREMENT," +
                "  EDITORA VARCHAR(50) NOT NULL," +
                "  TITULO VARCHAR(50) NOT NULL," +
                "  ISBN VARCHAR(50)  NOT NULL," +
                "  PRIMARY KEY (ID)\n" +
                ") ENGINE = MyISAM DAFAULT CHARSET=latin1 AUTO_INCREMENT=0;";