export interface IMovie {
    id: number;
    title: string;
    imdbId: string;
    year: string;
    watched: boolean;
    favourite: boolean;
}

export interface IMovieDetails {
    title?: string;
    year?: string;
    imdbId?: string;
    rated?: string;
    genre?: string;
    director?: string;
    writer?: string;
    actors?: string;
    plot?: string;
    poster?: string;
}

export interface IMovieReview {
    id: number;
    movieId: number;
    review?: string;
}

export class Movie implements IMovie {
    constructor(
        public id: number,
        public title: string,
        public imdbId: string,
        public year: string,
        public watched: boolean,
        public favourite: boolean,
    ) {
    }
}

export class MovieDetails implements IMovieDetails {
    constructor(
        public title?: string,
        public year?: string,
        public imdbId?: string,
        public rated?: string,
        public genre?: string,
        public director?: string,
        public writer?: string,
        public actors?: string,
        public plot?: string,
        public poster?: string,
    ) {
    }
}

export class MovieReview implements IMovieReview {
    constructor(
        public id: number,
        public movieId: number,
        public review?: string,
    ) {
    }
}
