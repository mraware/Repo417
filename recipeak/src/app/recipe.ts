import { User } from './user';
import { Flavor } from './flavor';

export class Recipe {
  constructor () {}
  public recipeId: number;
  public name: string;
  public flavor: Flavor;
  public creator: User;
  public privacy: string;
  public burns: number;
  public promoted: number;
  public notes: string;
}
