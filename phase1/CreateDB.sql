create table players (
	name varchar(20) not null,
    playerID integer(5),
    team_name varchar(25), #free agents possible
    pos varchar(2),
    touchdowns int(3),
    total_yards int(4),
    salary int(9) not null,
    check(pos in ('QB', 'RB', 'WR')),
    primary key(playerID)
);

create table games (
	gameID int(4),
    gameDate date not null,
    stadium varchar(20) not null,
    result char(1) check (result = 'W' or result = 'L' or result = 'T'),
    attendance int(6),
    ticketRev int(8),
    primary key(gameID)
);

create table play (
	gameID int(4),
    playerID int(5),
    foreign key (playerID) references players(playerID) on delete set null,
    foreign key (gameID) references games(gameID) on delete set null
);