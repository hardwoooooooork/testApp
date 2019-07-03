import React from 'react';
import { render } from '@testing-library/react';
import History from '../components/History';

describe('<History />', () => {
    it('matches snapshot', () => {
        const utils = render(<History />);
        expect(utils.container).toMatchSnapshot();
    });
});