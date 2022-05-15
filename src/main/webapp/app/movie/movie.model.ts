export interface IMovie {
  id?: number;
  title?: string;
  imdbId?: string;
  year?: string;
  watched?: boolean;
  favourite?: boolean;
}

export class Movie implements IMovie {
  constructor(
    public id?: number,
    public title?: string,
    public imdbId?: string,
    public year?: string,
    public watched?: boolean,
    public favourite?: boolean,
  ) {
  }
}
