import { User } from './user';
import { Recipe } from './recipe';

export class History {
    public id: number;
    public user: User;
    public recipe: Recipe;
    public saved: number;
    public score: number;
    public review: string;
    constructor () {}
}
