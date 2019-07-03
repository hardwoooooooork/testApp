import React from 'react';
import { render } from '@testing-library/react';
import UserJoin from '../components/UserJoin';


describe('<UserJoin />', () => {
    it('matches snapshot', () => {
        const utils = render(<UserJoin />);
        expect(utils.container).toMatchSnapshot();
    });
});