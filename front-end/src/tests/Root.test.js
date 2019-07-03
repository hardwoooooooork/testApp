import React from 'react';
import { render } from '@testing-library/react';
import Root from '../components/Root';
describe('<Root />', () => {
    it('matches snapshot', () => {
        const utils = render(<Root />);
        expect(utils.container).toMatchSnapshot();
    });
});